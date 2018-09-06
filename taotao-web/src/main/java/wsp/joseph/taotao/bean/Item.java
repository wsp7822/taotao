package wsp.joseph.taotao.bean;

import org.apache.commons.lang3.StringUtils;

public class Item extends wsp.joseph.taotao.pojo.Item {

    public String[] getImages() {
        return StringUtils.split(super.getImage(), ',');
    }

}
