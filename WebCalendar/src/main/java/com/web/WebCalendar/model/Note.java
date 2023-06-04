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
   private String note;
@ManyToMany(mappedBy = "notes")
   private Set<User> users;

   public Note(Long id, Date date, String note) {
      this.id = id;
      this.date = date;
      this.note = note;
   }

   public Note() {
   }

   public Set<User> getUsers() {
      return users;
   }

   public void setUsers(Set<User> users) {
      this.users = users;
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

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Note note1 = (Note) o;
      return Objects.equals(id, note1.id) && Objects.equals(date, note1.date) && Objects.equals(note, note1.note);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, date, note);
   }

   @Override
   public String toString() {
      return "Note{" +
              "id=" + id +
              ", date=" + date +
              ", note='" + note + '\'' +
              '}';
   }
}
