package com.example.asiftamal.chinesebanglaenglishdictionary.dictionaryfiles;

public class DictionaryDetailcls {
    public DictionaryDetailcls(int wordID, int isactive, String englishword, String banglaword, String pronctnbangla, String chineseword, String pronctnchinese, String audio, String DefinitionbanglaWord, String DefinitionEnglishWord) {
        this.wordID = wordID;
        this.isactive = isactive;
        this.englishword = englishword;
        this.banglaword = banglaword;
        this.pronctnbangla = pronctnbangla;
        this.chineseword = chineseword;
        this.pronctnchinese = pronctnchinese;
        this.audio = audio;
        this.DefinitionbanglaWord=DefinitionbanglaWord;
        this.DefinitionEnglishWord=DefinitionEnglishWord;
    }
    public DictionaryDetailcls() {

    }

    int wordID,isactive;
    String englishword,banglaword,pronctnbangla,chineseword,pronctnchinese, audio,DefinitionbanglaWord,DefinitionEnglishWord;

    public String getDefinitionbanglaWord() {
        return DefinitionbanglaWord;
    }

    public void setDefinitionbanglaWord(String definitionbanglaWord) {
        DefinitionbanglaWord = definitionbanglaWord;
    }

    public String getDefinitionEnglishWord() {
        return DefinitionEnglishWord;
    }

    public void setDefinitionEnglishWord(String definitionEnglishWord) {
        DefinitionEnglishWord = definitionEnglishWord;
    }

   // String DefinitionbanglaWord,DefinitionChineseWord;


    public int getWordID() {
        return wordID;
    }

    public void setWordID(int wordID) {
        this.wordID = wordID;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

    public String getEnglishword() {
        return englishword;
    }

    public void setEnglishword(String englishword) {
        this.englishword = englishword;
    }

    public String getBanglaword() {
        return banglaword;
    }

    public void setBanglaword(String banglaword) {
        this.banglaword = banglaword;
    }

    public String getPronctnbangla() {
        return pronctnbangla;
    }

    public void setPronctnbangla(String pronctnbangla) {
        this.pronctnbangla = pronctnbangla;
    }

    public String getChineseword() {
        return chineseword;
    }

    public void setChineseword(String chineseword) {
        this.chineseword = chineseword;
    }

    public String getPronctnchinese() {
        return pronctnchinese;
    }

    public void setPronctnchinese(String pronctnchinese) {
        this.pronctnchinese = pronctnchinese;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }



}
