package hbi.core.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import hbi.core.demo.dto.InventoryItems;
import hbi.core.demo.mapper.InventoryItemsMapper;
import hbi.core.demo.service.IFruitService;
import hbi.core.demo.service.IInventoryItemsService;

@Service
public class InventoryItemsServiceImpl extends BaseServiceImpl<InventoryItems>implements IInventoryItemsService {
	@Autowired
	private InventoryItemsMapper inventoryItemsMapper;

	@Override
	public List<InventoryItems> selectByInventoryItems(IRequest requestContext, InventoryItems inventoryItems, int page,
			int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return inventoryItemsMapper.selectByInventoryItems(inventoryItems);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<InventoryItems> batchUpdate(IRequest requestContext, List<InventoryItems> inventoryItem) {
		// TODO Auto-generated method stub
		for (InventoryItems inventoryItems : inventoryItem) {
			if (inventoryItems.get__status() != null) {
				switch (inventoryItems.get__status()) {
				case DTOStatus.ADD:
					inventoryItemsMapper.insertInventoryItems(inventoryItems);
					break;
				case DTOStatus.UPDATE:
					inventoryItemsMapper.updateInventoryItems(inventoryItems);
					break;
				case DTOStatus.DELETE:
					self().deleteByPrimaryKey(inventoryItems);
					break;
				default:
					break;
				}
			}
		}
		return inventoryItem;
	}
}
