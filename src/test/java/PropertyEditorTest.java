/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/6/19
 */
public class PropertyEditorTest {
    /**
     * 属性编辑器
     * PropertyEditor 是属性编辑器的接口，它规定了将外部设置值转化为内部JaveBean属性值的装换值的转换接口方法
     * 主要方法：
     *  Object getValue() ：返回属性的当前值，基本类型被封装为对应的引用类型
     *  void setValue(Object newValue) 设置属性值， 基本类型以封装类型传入
     *  String getAsText(): 将属性对象用一个字符串表示。
     *  void setAsText(String text) ：用一个字符串去更新属性的内部值
     *  String[] getTags():返回表示有效属性值的字符串组
     *  String getJavaInitializationString() : 为属性提供一个标识初始值的字符串
     *
     *  可以看出，PropertyEditor接口方法是内部属性值和外部属性值沟通桥梁
     *  java 为PropertyEditor提供了一个实现类PropertyEditorSupport，该类实现了PropertyEditor接口，用户可以通过扩展这个方
     *  法方便设计自己的属性编辑器
     *
     *  BeanInfo
     *  主要描述JavaBean的那些属性可以编辑以及对应的属性编辑器,每个属性对应一个属性描述器PropertyDescriptor
     *
     *
     */

    /**
     * Srping 的属性编辑器和传统的用于IDE开发时的属性编辑器不同,他们没有ui界面,仅负责将配置文件中的文本配置值的
     * 转化为Bean 属性的对应值
     *
     * Spring的大部分默认属性编辑器都直接扩展于java.bean.PropertyEditorSupport
     * Spring环境下属性编辑器功能单一,仅需要将配置文件中的字面值转化为属性类型的对象即可,并不需要提供ui界面,因此仅
     * 需要简单的覆盖setAsText方法
     */
}
