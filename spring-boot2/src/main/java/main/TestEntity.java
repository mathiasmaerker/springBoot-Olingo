package main;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TestEntity {

	@Id
	private Integer id;
	private String text;
		
}
