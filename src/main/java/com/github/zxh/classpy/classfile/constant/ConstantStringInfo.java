package com.github.zxh.classpy.classfile.constant;

import com.github.zxh.classpy.classfile.ClassComponent;
import com.github.zxh.classpy.classfile.ClassReader;
import com.github.zxh.classpy.classfile.datatype.U2;
import java.util.Arrays;
import java.util.List;

/*
CONSTANT_String_info {
    u1 tag;
    u2 string_index;
}
*/
public class ConstantStringInfo extends ConstantInfo {

    private U2 stringIndex;

    @Override
    protected void readInfo(ClassReader reader) {
        stringIndex = reader.readU2();
    }
    
    @Override
    protected String loadDesc(ConstantPool pool) {
        return pool.getUtf8Info(stringIndex).loadDesc(pool);
    }
    
    @Override
    public List<ClassComponent> getSubComponents() {
        return Arrays.asList(tag, stringIndex);
    }
    
}
