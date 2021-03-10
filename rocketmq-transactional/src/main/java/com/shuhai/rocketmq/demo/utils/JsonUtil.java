package com.shuhai.rocketmq.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述：
 *
 * @author 含光
 * @email jarvan_best@163.com
 * @date 2021/3/10 11:07 上午
 * @company 数海掌讯
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public JsonUtil() {
    }

    public static String toJSONString(Object o) {
        return toJSONString(o, false);
    }

    public static String toJSONString(Object o, boolean format) {
        try {
            if (o == null) {
                return "";
            } else if (o instanceof Number) {
                return o.toString();
            } else if (o instanceof String) {
                return (String)o;
            } else {
                return format ? MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o) : MAPPER.writeValueAsString(o);
            }
        } catch (JsonProcessingException var3) {
            throw new RuntimeException(var3);
        }
    }

    public static <T> T toObject(String json, Class<T> cls) {
        if (!StringUtils.isBlank(json) && cls != null) {
            try {
                return MAPPER.readValue(json, cls);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        } else {
            return null;
        }
    }

    public static <T> T toObject(String json, Class<?> parametrized, Class<?>... parameterClasses) {
        if (!StringUtils.isBlank(json) && parametrized != null) {
            try {
                JavaType javaType = MAPPER.getTypeFactory().constructParametricType(parametrized, parameterClasses);
                return MAPPER.readValue(json, javaType);
            } catch (IOException var4) {
                throw new RuntimeException(var4);
            }
        } else {
            return null;
        }
    }

    public static <T> T toObject(String json, TypeReference<T> typeReference) {
        if (!StringUtils.isBlank(json) && typeReference != null) {
            try {
                return MAPPER.readValue(json, typeReference);
            } catch (IOException var3) {
                throw new RuntimeException(var3);
            }
        } else {
            return null;
        }
    }

    public static JsonNode parse(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return MAPPER.readTree(json);
            } catch (IOException var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    public static <K, V> Map<K, V> toMap(Object o) {
        if (o == null) {
            return null;
        } else {
            return o instanceof String ? (Map)toObject((String)o, Map.class) : (Map)MAPPER.convertValue(o, Map.class);
        }
    }

    public static <T> List<T> toList(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                return (List)MAPPER.readValue(json, List.class);
            } catch (JsonProcessingException var2) {
                throw new RuntimeException(var2);
            }
        }
    }

    public static <T> List<T> toList(String json, Class<T> cls) {
        if (StringUtils.isBlank(json)) {
            return null;
        } else {
            try {
                JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, new Class[]{cls});
                return (List)MAPPER.readValue(json, javaType);
            } catch (JsonProcessingException var3) {
                throw new RuntimeException(var3);
            }
        }
    }

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        MAPPER.configure(JsonReadFeature.ALLOW_UNQUOTED_FIELD_NAMES.mappedFeature(), true);
        MAPPER.configure(JsonReadFeature.ALLOW_SINGLE_QUOTES.mappedFeature(), true);
        MAPPER.configure(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS.mappedFeature(), true);
        MAPPER.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        MAPPER.setSerializationInclusion(Include.NON_NULL);
        MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        MAPPER.enable(new MapperFeature[]{MapperFeature.USE_STD_BEAN_NAMING});
        MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
}
