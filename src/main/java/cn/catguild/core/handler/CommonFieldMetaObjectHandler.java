package cn.catguild.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 通用字段的填充处理器
 *
 * @author zhi.liu
 * @date 2021-07-02 17:55
 */
@Slf4j
@Component
public class CommonFieldMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		log.debug("start insert fill ....");
		this.strictInsertFill(metaObject, "createTime", System::currentTimeMillis, Long.class);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		log.debug("start update fill ....");
		this.strictUpdateFill(metaObject, "updateTime", System::currentTimeMillis, Long.class);
	}

}
