package erp.acc.basic.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Accounts {

	@Getter @Setter private String account_number;
	@Getter @Setter private String account_name;
	@Getter @Setter private int diagnosis_number;
	@Getter @Setter private String account_detail;
	@Getter @Setter private String remarks;
	@Getter @Setter private String use;
	
	
}
