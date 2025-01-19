package io.github.jamielu.jamiecache.core;

/**
 * @author jamieLu
 * @create 2024-06-19
 *
 * RESP协议 数据类型
 */
public enum ReplyType {
    INT, ERROR, SIMPLE_STRING, BULK_STRING, ARRAY;
}
