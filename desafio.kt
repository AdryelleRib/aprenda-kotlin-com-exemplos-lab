// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { 
    BASICO, INTERMEDIARIO, AVANCADO 
}

class Usuario(var nome: String)

data class ConteudoEducacional(var nome: String, val nivel: Nivel)     

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario, indiceConteudo: Int) {
        inscritos.add(usuario)
        if (conteudos.isNotEmpty() && indiceConteudo >= 0 && indiceConteudo < conteudos.size){
            val conteudo = conteudos[indiceConteudo]
            println("Aluno ${usuario.nome} matriculado no Curso de $nome ${conteudo.nome}, nível ${conteudo.nivel}")
        } else {
            println("Aluno ${usuario.nome} matriculado no Curso de $nome, sem conteúdos ou índice inválido.")
        }
        
    }
}

fun printAll(vararg strings: String) {
    strings.forEach {println(it)}
}

fun main() {
   val usuario1 = Usuario("Alex")
   val usuario2 = Usuario("Ana")
   val usuario3 = Usuario("João")
   val usuario4 = Usuario("Maria")
   
   val conteudos = listOf(
        ConteudoEducacional("KOTLIN", nivel = Nivel.AVANCADO),
        ConteudoEducacional("JAVA", nivel = Nivel.INTERMEDIARIO),
        ConteudoEducacional("C++", nivel = Nivel.BASICO),
        ConteudoEducacional("PYTHON", nivel = Nivel.BASICO)
   )
   
   val formacao = Formacao("Formação", conteudos)
   
   formacao.matricular(usuario1, 0)
   formacao.matricular(usuario2, 1)
   formacao.matricular(usuario3, 2)
   formacao.matricular(usuario4, 3)
   
}