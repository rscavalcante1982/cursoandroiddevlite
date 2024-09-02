class Livro(){
   var nome:String = ""
   var totaldepaginas = 0
   var paginaslidas  = 0

    fun setnome(nome:String): Boolean {
        var isValid = false

        if (nome != ""){
            this.nome = nome
            isValid = true
        }
        return isValid
    }

    fun settotaldepaginas(totaldepaginas:Int):Boolean{
        var totpg :Boolean = false
        if(totaldepaginas > 0) {
            this.totaldepaginas = totaldepaginas
            totpg = true
        }
        return totpg
    }

    fun setpaginaslidas(paginaslidas: Int):Boolean{
        var lidas : Boolean = false
        if(paginaslidas <= this.totaldepaginas) {
            this.paginaslidas = paginaslidas
            lidas = true
        }
        return lidas
    }

    fun progressaoleitura(): Double {
       var percLeitura: Double = (paginaslidas.toDouble() / totaldepaginas.toDouble()) * 100.0
        return percLeitura
    }

}
fun main(){
    var livro : Livro = Livro()
    var nome:String
    var totaldepaginas:Int
    var paginaslidas: Int

    while(true) {
       println("Informe o nome do livro: ")
       nome = readln()
       if (livro.setnome(nome)){
           break
       }else{
           println("O ${nome} informado é invalido")
       }
    }
    while(true){
        println("Informe o total de paginas do livro: ")
        totaldepaginas = readlnOrNull()?.toInt()?:0
        if (livro.settotaldepaginas(totaldepaginas)){
            break
        }
    }

    while(true){
        println("Informe a quantidade de paginas lidas do livro: ")
        paginaslidas = readlnOrNull()?.toInt()?:0
        if ( livro.setpaginaslidas(paginaslidas)){
            break
        }
    }
    println("O nome do livro é ${livro.nome}")
    println("A progressao de leitura é ${livro.progressaoleitura()}%")

}