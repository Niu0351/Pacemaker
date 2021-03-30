package dao.impl;

import dao.ModeDao;
import pojo.Mode;

public class ModeDaoImpl extends BaseDao implements ModeDao {

    @Override
    public int saveMode(Mode mode) {
        String sql = "insert into mode (id,mode,LRL,URL,AA,VA,APW,VPW,VRP,ARP) values(?,?,?,?,?,?,?,?,?,?)";
        return update(sql, mode.getId(),mode.getMode(),mode.getLRL(),mode.getURL(),mode.getAA(),mode.getVA(),mode.getAPW(),mode.getVPW(),mode.getVRP(),mode.getARP());
    }

}
