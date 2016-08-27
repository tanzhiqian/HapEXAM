package hbi.core.demo.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hbi.core.demo.dto.InventoryItems;

public interface InventoryItemsMapper extends Mapper<InventoryItems> {
	List<InventoryItems> selectByInventoryItems(InventoryItems inventoryItems);

	int insertInventoryItems(InventoryItems inventoryItems);

	int deleteInventoryItems(InventoryItems inventoryItems);

	int updateInventoryItems(InventoryItems inventoryItems);
}
