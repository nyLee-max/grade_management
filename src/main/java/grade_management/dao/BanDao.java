package grade_management.dao;

import java.util.List;

import grade_management.dto.Ban;

public interface BanDao {
	List<Ban> selectBanByAll();
	
	int insertBan(Ban ban);
	int deleteBan(Ban ban);
	
}
