enum class Nivel {Básico, Intermediário, Avançado}

data class Usuario(val nome: String, val email: String, val tipoUsuario: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun imprimirListaInscritos(){
        for(user in inscritos){
            println(user.nome)
        }
    }
    
    fun imprimirGradeFormacao(){
        for(cont in conteudos){
            println("${cont.nome} - ${cont.duracao}")
        }
    }
}

fun main() {
    
    val moduloJava = ConteudoEducacional("Curso de Java", 60, Nivel.Básico)
    val moduloReact = ConteudoEducacional("Curso de React", 80, Nivel.Intermediário)
    val moduloAndroid = ConteudoEducacional("Curso de Swift", 120, Nivel.Avançado)
    
    val listConteudos = mutableListOf<ConteudoEducacional>()
    listConteudos.add(moduloJava)
    listConteudos.add(moduloReact)
    listConteudos.add(moduloAndroid)
    
    val formacaoAndroid = Formacao("Formação Android", listConteudos, Nivel.Básico)
    
    val Antônio = Usuario("Antônio", "antonio@gmail.com", "free")
    val Maria = Usuario("Maria", "maria@gmail.com", "premium")
    val João = Usuario("João", "joao@gmail.com", "free")
    
    formacaoAndroid.matricular(Antônio)
    formacaoAndroid.matricular(Maria)
    formacaoAndroid.matricular(João)
    
    print("Formação: ")
    println("${formacaoAndroid.nome} - ${formacaoAndroid.nivel}")
    println("Grade de Cursos: ")
    println(formacaoAndroid.imprimirGradeFormacao())
    println()
    println("Lista de inscritos aceitos: ")
    println(formacaoAndroid.imprimirListaInscritos())
}
