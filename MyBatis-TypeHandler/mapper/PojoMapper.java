package mapper;

import pojo.PojoDAO;

public interface PojoMapper {
	PojoDAO selectPojo(Long id);
}
