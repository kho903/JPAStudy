package hellojpa.advancedmapping.복합키와식별관계매핑.비식별관계.idclass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Child {

	@Id
	private String id;

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "PARENT_ID1",
			referencedColumnName = "PARENT_ID1"),
		@JoinColumn(name = "PARENT_ID2",
			referencedColumnName = "PARENT_ID2")
	})
	private Parent parent;
}
