
package aed.trie;

class No<T>{
    T valor;
    No[] filhos;

    No(int tamanho) {
        filhos = new No[tamanho];
        for(int i=0; i<tamanho; i++)
            filhos[i] = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No[] getFilhos() {
        return filhos;
    }

    public void setFilhos(No[] filhos) {
        this.filhos = filhos;
    }
    
}
