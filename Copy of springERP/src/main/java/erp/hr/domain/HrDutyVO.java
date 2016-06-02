package erp.hr.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HrDutyVO implements Serializable{
	@Getter @Setter
	private String duty_id;
	@Getter @Setter
	private String duty_name;
}
