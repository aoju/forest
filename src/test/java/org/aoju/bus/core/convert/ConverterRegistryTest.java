package org.aoju.bus.core.convert;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ConverterRegistry 单元测试
 */
public class ConverterRegistryTest {

    @Test
    public void getConverterTest() {
        Converter<Object> converter = ConverterRegistry.getInstance().getConverter(CharSequence.class, false);
        Assertions.assertNotNull(converter);
    }

    @Test
    public void customTest() {
        int a = 454553;
        ConverterRegistry converterRegistry = ConverterRegistry.getInstance();

        CharSequence result = converterRegistry.convert(CharSequence.class, a);
        Assertions.assertEquals("454553", result);

        //此处做为示例自定义CharSequence转换，因为已经提供CharSequence转换，请尽量不要替换
        //替换可能引发关联转换异常（例如覆盖CharSequence转换会影响全局）
        converterRegistry.putCustom(CharSequence.class, CustomConverter.class);
        result = converterRegistry.convert(CharSequence.class, a);
        Assertions.assertEquals("Custom: 454553", result);
    }

    public static class CustomConverter implements Converter<CharSequence> {
        @Override
        public CharSequence convert(Object value, CharSequence defaultValue) throws IllegalArgumentException {
            return "Custom: " + value.toString();
        }
    }

}
