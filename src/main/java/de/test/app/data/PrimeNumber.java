package de.test.app.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="primenumbers")
@Getter
@Setter
public class PrimeNumber {

    @Id
    public int id;

    public int primeNumber;

}
