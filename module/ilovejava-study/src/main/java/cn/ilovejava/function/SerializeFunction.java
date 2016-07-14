package cn.ilovejava.function;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yqy on 2016/7/14.
 */
public class SerializeFunction {
    /**
     * 返回 0 表示无记录
     * 返回 1 表示已喜欢
     * 返回 2 表示已不喜欢
     * @param name
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static int likeAndIpAuth(long id,String name,boolean like) throws IOException, ClassNotFoundException {
        File file = new File(SerializeFunction.class.getResource("/likeAndIpAuth").getFile());
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            Map<Long,List[]> obj = (Map<Long,List[]>)objectInputStream.readObject();//文件中已有数据
            List[] larr = obj.get(id);
            if(larr!=null&&larr.length>0){
                if(larr[0].contains(name)){//存在已喜欢的
                    return 1;
                }else if(larr[1].contains(name)){//存在已不喜欢的
                    return 2;
                }else{//都不存在
                    if(like){
                        larr[0].add(name);
                    }else{
                        larr[1].add(name);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    objectOutputStream.close();
                    objectInputStream.close();
                    return 0;
                }
            }else{
                List<String> list1 = new ArrayList<>();
                List<String> list2 = new ArrayList<>();
                List[] ips = {list1,list2};
                if(like){
                    list1.add(name);
                }else{
                    list2.add(name);
                }
                obj.put(id, ips);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                objectOutputStream.close();
                objectInputStream.close();
                return 0;
            }
        }catch (EOFException e){//如果没有数据
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            Map<Long,List[]> mp = new HashMap();
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            List[] ips = {list1,list2};
            if(like){
                list1.add(name);
            }else{
                list2.add(name);
            }

            mp.put(id, ips);
            objectOutputStream.writeObject(mp);
            objectOutputStream.flush();
            objectOutputStream.close();
            return 0;
        }

    }
}
