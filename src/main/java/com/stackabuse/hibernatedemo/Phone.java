package com.stackabuse.hibernatedemo;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "phones")
@EntityListeners(AuditingEntityListener.class)
public class Phone {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(name = "phone_name", nullable = false)
  private String phoneName;

  @Column(name = "os", nullable = false)
  private String os;

  public UUID getId() {
    return id;
  }

  public void setId(UUID value) {
    this.id = value;
  }

  public String getPhoneName() {
    return phoneName;
  }

  public void setPhoneName(String value) {
    this.phoneName = value;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String value) {
    this.os = value;
  }

}
