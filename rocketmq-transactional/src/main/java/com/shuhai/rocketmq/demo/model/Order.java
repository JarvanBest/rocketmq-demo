package com.shuhai.rocketmq.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {
	private static final long serialVersionUID = 2801814838883246461L;

	private Long orderId;
	private String orderNo;
}
