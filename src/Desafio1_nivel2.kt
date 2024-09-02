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
fun main() {
    var livros: ArrayList<Livro_> = ArrayList()
    var opcao: Int = 0

    while (opcao != 3) {
        println("Menu de opcoes")
        println("1-Cadastrar")
        println("2-Consultar")
        println("3-Sair")
        println("Informe a opcao desejada: ")
        opcao = readlnOrNull()?.toInt() ?: 0

        if (opcao == 1) {
            livros.add(cadastrar())
            //println("Total livros ${livros.size}")
        }else if(opcao == 2){
           consultar(livros)
        }
    }
}
fun cadastrar():Livro_ {
    var olivro: Livro_ = Livro_()
    var nome: String
    var genero: String
    var autor: String
    var totaldepaginas: Int
    var paginaslidas: Int

    while (true) {
        println("Informe o nome do livro: ")
        nome = readln()
        if (olivro.setnome(nome)) {
            break
        } else {
            println("O ${nome} informado é invalido")
        }
    }

    while (true) {
        println("Informe o genero do livro: ")
        genero = readln()
        if (olivro.setgenero(genero)) {
            break
        } else {
            println("O ${genero} informado é invalido")
        }
    }

    while (true) {
        println("Informe o autor do livro: ")
        autor = readln()
        if (olivro.setautor(autor)) {
            break
        } else {
            println("O ${autor} informado é invalido")
        }
    }

    while (true) {
        println("Informe o total de paginas do livro: ")
        totaldepaginas = readlnOrNull()?.toInt() ?: 0
        if (olivro.settotaldepaginas(totaldepaginas)) {
            break
        }
    }

    while (true) {
        println("Informe a quantidade de paginas lidas do livro: ")
        paginaslidas = readlnOrNull()?.toInt() ?: 0
        if (olivro.setpaginaslidas(paginaslidas)) {
            break
        }
    }
    return olivro
}

fun consultar(livros : ArrayList<Livro_>){
    var tipoConsulta:Int = 0
    var consulta:String
    var olivro:Livro_ = Livro_()


    println("Total livros ${livros.size}")

    while (tipoConsulta != 4) {
        var _livros: ArrayList<Livro_> = ArrayList()
        println("Escolha o tipo de consulta")
        println("1-Nome")
        println("2-Genero")
        println("3-Autor")
        println("4-Menu principal")
        println("Informe a opcao desejada: ")
        tipoConsulta = readlnOrNull()?.toInt() ?: 0


        if(tipoConsulta == 1){

            println("Informe o nome do livro: ")
            consulta = readln()

            for(pos in 0.. livros.size-1){

                if(livros[pos].nome.lowercase() == consulta.lowercase() ) {
                    _livros.add(livros[pos])
                }
            }
        }

        if(tipoConsulta == 2){

            println("Informe o Genero do livro: ")
            consulta = readln()

            for(pos in 0.. livros.size-1){

                if(livros[pos].genero.lowercase() == consulta.lowercase() ) {
                    _livros.add(livros[pos])
                }
            }
        }
        if(tipoConsulta == 3){

            println("Informe o Autor do livro: ")
            consulta = readln()

            for(pos in 0.. livros.size-1){

                if(livros[pos].autor.lowercase() == consulta.lowercase() ) {
                    _livros.add(livros[pos])
                }
            }
        }

        for(pos in 0.. _livros.size-1){
            olivro = _livros[pos]
            println("O nome do livro é ${olivro.nome}")
            println("O total de paginas do livro ${olivro.totaldepaginas}")
            println("O numero de paginas lidas ${olivro.paginaslidas}")
            println("O genero do livro é ${olivro.genero}")
            println("A classificacao do livro é ${olivro.classificacao}")
            println("A progressao de leitura é ${olivro.progressaoleitura()}%")
            println("-------------")
        }

     }
}

