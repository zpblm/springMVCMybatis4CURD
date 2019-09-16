package cn.kgc.mapper;

import cn.kgc.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Insert(" insert into emp (id,name,addr) values (#{id},#{name},#{addr}) ")
    public void add(User user);

    @Delete(" delete from emp where id= #{id} ")
    public void delete(int id);

    @Select("select * from emp where id= #{id} ")
    public User get(int id);

    @Update("update emp set name=#{name},addr=#{addr} where id=#{id} ")
    public void update(User user);

    @Select(" select * from emp ")
    public List<User> list();
}