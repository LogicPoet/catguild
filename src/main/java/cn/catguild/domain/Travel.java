package cn.catguild.domain;

import lombok.Data;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

/**
 * <p>
 *
 * </p>
 *
 * @author zhi.liu
 * @version V1.0
 * @package cn.catguild.domain
 * @description
 * @date Created in 2020-09-09 01:50
 * @copyright Copyright (c) 2020
 * @modified zhi.liu
 */
@Data
public class Travel {
	String callsign;
	String country;
	String iata;
	String icao;
	Integer id;
	String name;
	String type;
}
