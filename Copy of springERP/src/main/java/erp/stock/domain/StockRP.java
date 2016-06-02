package erp.stock.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class StockRP {

	@Getter @Setter
	private String inout_id;
	@Getter @Setter
	private int inout_amount;
	@Getter @Setter
	private Date stock_indate;
	@Getter @Setter
	private Date stock_outdate;
	@Getter @Setter
	private String product_id;
	@Getter @Setter
	private String emp_id;
	@Getter @Setter
	private String type;
}
