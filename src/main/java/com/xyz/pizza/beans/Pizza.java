package com.xyz.pizza.beans;

public class Pizza {

	
	 private final String name; // required
	    private final long time; // optional
	    private final String topping; // optional
	    private final String cheese; // optional
	    
	    
	    private Pizza(PizzaBuilder builder) {
	        this.name = builder.name;
	        this.time = builder.time;
	        this.topping = builder.topping;
	        this.cheese = builder.cheese;
	    }
	 
	  public String getName() {
			return name;
		}

		public long getTime() {
			return time;
		}

		public String getTopping() {
			return topping;
		}

		public String getCheese() {
			return cheese;
		}

	  
	 
	    @Override
		public String toString() {
			return "File [name=" + name + ", time=" + time + ", topping=" + topping + ", cheese=" + cheese + "]";
		}



		public static class PizzaBuilder{
	  	  
	  	    private final String name; // required
	        private long time; // optional
	        private String topping; // optional
	        private String cheese; // optional
	 
	        public PizzaBuilder(String name) {
	            this.name = name;
	        }
	        public PizzaBuilder topping(String topping) {
	            this.topping = topping;
	            return this;
	        }
	        public PizzaBuilder cheese(String cheese) {
	            this.cheese = cheese;
	            return this;
	        }
	        public PizzaBuilder time(long time) {
	            this.time = time;
	            return this;
	        }
	        
	        public Pizza build() {
	            Pizza bean =  new Pizza(this);
	            validateUserObject(bean);
	            return bean;
	        }
	        private void validateUserObject(Pizza bean) {
	            //Do some basic validations to check
	            //if user object does not break any assumption of system
	        }
	    }
}
