package contest.codewars.level7kyu

fun main() {
    makeComplement("ATTGC ") // TAACG
    makeComplement("GTAT ") // CATA
}

private fun makeComplement (dna: String) = dna.map { when(it) {
    'A' -> 'T'
    'T' -> 'A'
    'C' -> 'G'
    'G' -> 'C'
    else -> it
} }.joinToString("")


fun makeComplement2(dna : String) : String = dna.fold(String()) { acc, nucleotide ->
    acc + when (nucleotide) {
        'A' -> 'T'
        'C' -> 'G'
        'G' -> 'C'
        'T' -> 'A'
        else -> throw IllegalArgumentException("DNA may only contain nucleotides in A, C, G and T")
    }
}

fun makeComplement3(dna : String)=dna.map{"ATGC".zip("TACG").toMap()[it]?:it}.joinToString("")

fun makeComplement4(dna : String) : String {
    val answer = StringBuilder()
    for (i in dna) {
        when (i) {
            'A' -> answer.append("T")
            'T' -> answer.append("A")
            'G' -> answer.append("C")
            'C' -> answer.append("G")
        }
    }

    return answer.toString()
}

fun makeComplement5(dna : String)
        = dna.replace('A','t')
    .replace('T','a')
    .replace('C','g')
    .replace('G','c')
    .uppercase()