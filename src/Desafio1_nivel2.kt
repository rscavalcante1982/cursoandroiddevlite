class Livro_(){
    var nome:String = ""
    var genero:String = ""
    var autor = ""
    var totaldepaginas = 0
    var paginaslidas  = 0
    var classificacao:String = ""
    val classes = arrayOf("Livre", "10 anos", "12 anos","14 anos","18 anos")

    fun setnome(nome:String): Boolean {
        var isValid = false

        if (nome != ""){
            this.nome = nome
            isValid = true
        }
        return isValid
    }

    fun setgenero(genero:String): Boolean {
        var isValid = false

        if (genero != ""){
            this.genero = genero
            this.classificacao(genero)
            isValid = true
        }
        return isValid
    }

    fun setautor(autor:String): Boolean {
        var isValid = false

        if (autor != ""){
            this.autor = autor
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
       val percLeitura: Double = (paginaslidas.toDouble() / totaldepaginas.toDouble()) * 100.0
        return percLeitura
    }

    fun classificacao(genero:String){

        if (genero.lowercase() == "aventura" || genero.lowercase() == "Comedia" ) {
            this.classificacao = classes[0]
        }
        if (genero.lowercase() == "fantasia" || genero.lowercase() == "drama") {
            this.classificacao = classes[1]
        }
        if (genero.lowercase() == "musical" || genero.lowercase() == "biografico") {
            this.classificacao = classes[2]
        }
        if (genero.lowercase() == "ficcao cientifica" || genero.lowercase() == "romance") {
            this.classificacao = classes[3]
        }
        if (genero.lowercase() == "acao" || genero.lowercase() == "terror" ) {
            this.classificacao = classes[4]
        }
        //println("classificacao ${classificacao}")
    }

}
fun main(){
    val olivro : Livro_ = Livro_()
    var nome:String
    var genero:String
    var autor:String
    var totaldepaginas:Int
    var paginaslidas: Int

    while(true) {
       println("Informe o nome do livro: ")
       nome = readln()
       if (olivro.setnome(nome)){
           break
       }else{
           println("O ${nome} informado é invalido")
       }
    }

    while(true) {
        println("Informe o genero do livro: ")
        genero = readln()
        if (olivro.setgenero(genero)){
            break
        }else{
            println("O ${genero} informado é invalido")
        }
    }

    while(true) {
        println("Informe o autor do livro: ")
        autor = readln()
        if (olivro.setautor(autor)){
            break
        }else{
            println("O ${autor} informado é invalido")
        }
    }

    while(true){
        println("Informe o total de paginas do livro: ")
        totaldepaginas = readlnOrNull()?.toInt()?:0
        if (olivro.settotaldepaginas(totaldepaginas)){
            break
        }
    }

    while(true){
        println("Informe a quantidade de paginas lidas do livro: ")
        paginaslidas = readlnOrNull()?.toInt()?:0
        if ( olivro.setpaginaslidas(paginaslidas)){
            break
        }
    }
    println("O nome do livro é ${olivro.nome}")
    println("O total de paginas do livro ${olivro.totaldepaginas}")
    println("O numero de paginas lidas ${olivro.paginaslidas}")
    println("O genero do livro é ${olivro.genero}")
    println("A classificacao do livro é ${olivro.classificacao}")
    println("A progressao de leitura é ${olivro.progressaoleitura()}%")

}