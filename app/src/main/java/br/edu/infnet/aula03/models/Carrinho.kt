package br.edu.infnet.aula03.models

class Carrinho(){

    var valorTotal: Double = 0.0
    var listaCompra: MutableList<ItemCarrinho> = mutableListOf()

    fun calcularPrecoTotal(){
        var soma = 0.0
        for (item in listaCompra ){
            soma+= item.preco*item.quantidade
        }
        valorTotal  = soma
        println("valorTotal = R$: ${valorTotal}")
    }

    fun getPositionItem(item: ItemCarrinho): Int {

        listaCompra.forEachIndexed{ index, itemLista ->
            // Para cada item na lista de compra verifique se tem o mesmo nome de item
            if (item.nome == itemLista.nome){
                // Se tiver adicione a quantidade ao item que já está lá
                return index
            }
        }

        return -1
    }

    fun removerItem (item: ItemCarrinho) {

        var posicao = getPositionItem(item)

        if (posicao > -1){
            println(" item.quantidade                 = ${item.quantidade}")
            println(" listaCompra[posicao].quantidade = ${listaCompra[posicao].quantidade}")
            if (item.quantidade >= listaCompra[posicao].quantidade){
                listaCompra.removeAt(posicao)
            } else {
                listaCompra[posicao].quantidade -= item.quantidade
            }
        }

        println("\n\nLista atual: ")
        for (item in listaCompra){
            println("${item.nome} - ${item.quantidade}")
        }

        calcularPrecoTotal()
    }

    fun adicionarItem(item: ItemCarrinho)  {
        var estaNaLista = false

        listaCompra.forEachIndexed{ index, itemLista ->
            // Para cada item na lista de compra verifique se tem o mesmo nome de item
            if (item.nome == itemLista.nome){
                // Se tiver adicione a quantidade ao item que já está lá
                listaCompra[index].quantidade += item.quantidade
                estaNaLista = true
            }
        }
        if(!estaNaLista){
            listaCompra.add(item)
        }

        println("\n\nLista atual: ")
        for (item in listaCompra){
            println("${item.nome} - ${item.quantidade}")
        }

        calcularPrecoTotal()
    }

    fun getQuantidadeItem(item: ItemCarrinho): Int{

        val index = getPositionItem(item)

        if(index>-1) return listaCompra.get(index).quantidade

        return 0
    }
    // métodos adicionar - remover - calcular total
}