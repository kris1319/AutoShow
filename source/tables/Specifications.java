package logic;

import java.util.Set;
import java.util.HashSet;

public class Specifications {
	private Long car_id;
	private Integer engine_power;
	private Double fuel_consumption;
	private Boolean auto_transmission;
	private Car car;
	
	public Specifications() {}
	
	public Specifications(Long i, Integer e, Double f, Boolean a) {
		this.car_id = i;
		this.engine_power = e;
		this.fuel_consumption = f;
		this.auto_transmission = a;
	}
	
	public void setCarId(Long new_car) {
		this.car_id = new_car; 
	}
	
	public Long getCarId() {
		return car_id;
	}
	
	public void setEnginePower(Integer new_pow) {
		this.engine_power = new_pow;
	}
	
	public Integer getEnginePower() {
		return engine_power;
	}
	
	public void setFuelConsumption(Double new_fc) {
		this.fuel_consumption = new_fc;
	}
	
	public Double getFuelConsumption() {
		return fuel_consumption;
	}
	
	public void setAutoTransmission(Boolean new_st) {
		this.auto_transmission = new_st;
	}
	
	public Boolean getAutoTransmission() {
		return auto_transmission;
	}
	
	public void setCars(Car new_car) {
		this.car = new_car;
	}
	
	public Car getCars() {
		return car;
	}
}

