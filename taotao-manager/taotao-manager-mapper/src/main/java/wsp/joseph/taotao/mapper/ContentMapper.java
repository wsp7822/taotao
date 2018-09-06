package wsp.joseph.taotao.mapper;

import com.github.abel533.mapper.Mapper;
import wsp.joseph.taotao.pojo.Content;

import java.util.List;

public interface ContentMapper extends Mapper<Content> {

    /**
     * 根据categoryId查询内容列表，并且按照更新时间倒序排序
     * 
     * @return
     */
    List<Content> queryContentList(Long categoryId);

}
