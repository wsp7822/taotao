package wsp.joseph.taotao.service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wsp.joseph.taotao.common.bean.EasyUIResult;
import wsp.joseph.taotao.mapper.ItemParamMapper;
import wsp.joseph.taotao.pojo.Item;
import wsp.joseph.taotao.pojo.ItemParam;

import java.util.List;

@Service
public class ItemParamService extends BaseService<ItemParam>{

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemParamService.class);

    @Autowired
    private ItemParamMapper itemParamMapper;

    public EasyUIResult queryParamItemList(Integer page, Integer rows) {

        // 设置分页参数
        PageHelper.startPage(page, rows);

        Example example = new Example(Item.class);
        // 安装创建时间排序
        example.setOrderByClause("created DESC");
        List<ItemParam> items = this.itemParamMapper.selectByExample(example);

        PageInfo<ItemParam> pageInfo = new PageInfo<ItemParam>(items);

        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
