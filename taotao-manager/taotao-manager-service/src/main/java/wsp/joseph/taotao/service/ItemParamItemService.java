package wsp.joseph.taotao.service;

import com.github.abel533.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsp.joseph.taotao.mapper.ItemParamItemMapper;
import wsp.joseph.taotao.pojo.ItemParamItem;

import java.util.Date;

@Service
public class ItemParamItemService extends BaseService<ItemParamItem> {

    @Autowired
    private ItemParamItemMapper itemParamItemMapper;

    public Integer updateItemParamItem(Long itemId, String itemParams) {
        // 更新数据
        ItemParamItem itemParamItem = new ItemParamItem();
        itemParamItem.setParamData(itemParams);
        itemParamItem.setUpdated(new Date());

        // 更新的条件
        Example example = new Example(ItemParamItem.class);
        example.createCriteria().andEqualTo("itemId", itemId);

        return this.itemParamItemMapper.updateByExampleSelective(itemParamItem, example);
    }

}
