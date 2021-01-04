package com.company.StringManipulation;

public class GameOfThrones {
    public static void main(String[] args) {
        String test = "jzrvgnywrcihhmrsdwywuuevbsygjejufdrlqpjjssqbejvjgwiaqmytgwbralmfqdqivarpsiqyrnjzlrcdfaxlyydzlrgbwzjrbbgvlyteoeezwgddgapeyufmnonjnzboajjnierwivvgbakjabqbxvnkjctybwmdgxqodimofhwhiiskjilggasrfmqiiemoeeejoqxuaudievuogiwmkpdpdvyncmcgqipfzpzzlejpzfffnetyvznyunlwzpesywxzlyywcjndotjcxecsdpsyfdwevdwtzvsmvskzdxdrqovpsxjwpbwuhuacxzxywrmsjwrouwfmmdefapdrrznavoevpdtlugdfextavapidtpgiszbtndqdjlsmhdgpjntgiudjjloecuouuspjxgmhtetajcpsrjaafelqrzwuwkqqeibcqnjjtemcgbxymxatdljvkfrgshyypzaholrjqdoyglwtkymojylufccxjdybcaitmbceeqcldbgozuejspfyrhxckvdpwmkkpmoufqhirpytjcccrjcksznfxquteedustqzjzidoiwzlabejfpbfcgeuczbiexdxnciomlcvjbijfmumdythgxcjwdtaayxpbgdpthkdkuorhjemhxunvwytbuwdstuvbzlxgxassombzqniphwmfwgiqcnjxhgbiryqpajjqvksnzacjwrqvzzldowayddgwdxnfiwyfgqsiqwrpphkoixrxwuxzxdxdclikhgrqwlypirgzaqojpfilzfmzkkcpxmzettwrewionooogczwhjhjqwiaimpfyrjtkiloetduktiqvjmeswniuxkclchkvsdhaqxhmcbwvlmqubvozkytikvvmcfjwlqzbognqhlmuyeqbzeamctwoqrbuxkqidplrxzjgkvakaqnbwpnaijpabquaclifctyauiihfjthbjjyyyyhinjldelirvptqovnyeudpplqywoxungeappgtcomxfgqvddt";
        System.out.println(gameOfThrones(test));
    }

    static String gameOfThrones(String s) {
        int[] chars = new int[30];
        s.chars().forEach(value -> {
            System.out.println(value - 97);
            chars[value - 97]++;
        });
        int length = s.length();
        int numberOfOdds = 0;
        boolean ok = true;
        boolean even = length % 2 == 0;
        for (int aChar : chars) {
            if (aChar % 2 != 0) {
                numberOfOdds++;
            }
        }

        if((even && numberOfOdds == 0) || (!even && numberOfOdds == 1)) {
            return "YES";
        }

        return "NO";

    }
    //
}
