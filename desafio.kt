enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

class Usuario(val nivel: Nivel = Nivel.BASICO)  // Adicionei o nível do usuário

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)  // Adiciona o usuário à lista de inscritos
    }
}

fun main() {
    val usuario1 = Usuario(Nivel.BASICO)
    val usuario2 = Usuario(Nivel.INTERMEDIARIO)
    val usuario3 = Usuario(Nivel.AVANÇADO)// Adiciona Niveis
 
    val cursoKotlinBasico = ConteudoEducacional("Kotlin Básico", 30)
    val cursoKotlinIntermediario = ConteudoEducacional("Kotlin Intermediario", 65)
    val cursoKotlinAvancado = ConteudoEducacional("Kotlin Avançado", 100)

    val formacaoKotlin = Formacao("Formação em Kotlin", listOf(cursoKotlinBasico, cursoKotlinAvancado))

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)

    println("Usuários matriculados no curso Kotlin:")
    for (usuario in formacaoKotlin.inscritos) {
        println(" - $usuario - Nível: ${usuario.nivel}")
    }
}
