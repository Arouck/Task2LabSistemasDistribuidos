package desafio;

import java.util.Random;

public class Individuo {

    private String genes = "";
    private double aptidao = Double.MAX_VALUE;

    //gera um indivíduo aleatório
    public Individuo(int numGenes) {
        genes = "";
        Random r = new Random();

        String caracteres = Algoritmo.getCaracteres();

        genes += caracteres.charAt(r.nextInt(caracteres.length()));
        genes += '.';
        for (int i = 0; i < numGenes-2; i++) {
            genes += caracteres.charAt(r.nextInt(caracteres.length()));
        }

        geraAptidao();
    }

    //cria um indivíduo com os genes definidos
    public Individuo(String genes) {
        this.genes = genes;

        Random r = new Random();
        //se for mutar, cria um gene aleatório
        if (r.nextDouble() <= Algoritmo.getTaxaDeMutacao()) {
            String caracteres = Algoritmo.getCaracteres();
            String geneNovo="";
            int posAleatoria = r.nextInt(genes.length());
            for (int i = 0; i < genes.length(); i++) {
                if (i==posAleatoria){
                    geneNovo += caracteres.charAt(r.nextInt(caracteres.length()));
                }else{
                    geneNovo += genes.charAt(i);
                }

            }
            this.genes = geneNovo;
        }
        geraAptidao();
    }

    //gera o valor de aptidão, será calculada pelo número de bits do gene iguais ao da solução
    private void geraAptidao() {
        /*String solucao = Algoritmo.getSolucao();
        for (int i = 0; i < solucao.length(); i++) {
            if (solucao.charAt(i) == genes.charAt(i)) {
                aptidao++;
            }
        }*/
        double num = Double.parseDouble(genes);
        aptidao = (1.58 * num) - 9.0;
    }

    public double getAptidao() {
        return aptidao;
    }

    public String getGenes() {
        return genes;
    }
}
