package com.web.WebCalendar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "notes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Note {
   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @Column(name = "date")
   private Date date;
   @Column(name = "note")
   private String text;
   @Column(name = "user_id")
   private Long userId;

   public Note(Long id, Date date, String text) {
      this.id = id;
      this.date = date;
      this.text = text;
   }

   public Note() {
   }



   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }

   public Long getUserId() {
      return userId;
   }

   public void setUserId(Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Note note1 = (Note) o;
      return Objects.equals(id, note1.id) && Objects.equals(date, note1.date) && Objects.equals(text, note1.text);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, date, text);
   }

   @Override
   public String toString() {
      return "Note{" +
              "id=" + id +
              ", date=" + date +
              ", text='" + text + '\'' +
              '}';
   }
}
