package com.mcenk.NeuroBloom.dto;

import java.time.LocalDateTime;
import java.util.List;

public class EntryResponse {
    private Long id;
    private String word;
    private String meaning;
    private List<String> sentences;
    private List<String> relatedWords;
    private LocalDateTime createdDate;


    public EntryResponse(Long id, String word, String meaning, List<String> sentences, List<String> relatedWords, LocalDateTime createdDate) {
        this.id = id;
        this.word = word;
        this.meaning = meaning;
        this.sentences = sentences;
        this.relatedWords = relatedWords;
        this.createdDate = createdDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public List<String> getSentences() {
        return sentences;
    }

    public void setSentences(List<String> sentences) {
        this.sentences = sentences;
    }

    public List<String> getRelatedWords() {
        return relatedWords;
    }

    public void setRelatedWords(List<String> relatedWords) {
        this.relatedWords = relatedWords;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
