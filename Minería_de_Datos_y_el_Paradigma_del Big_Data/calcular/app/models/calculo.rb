

class Calculo
  include Mongoid::Document
  field :op1, type: Integer
  field :op2, type: Integer
  field :operador, type: String
  field :t0, type: Time
  field :t1, type: Time
  field :medicion, type: Float
  field :estimate, type: String
  field :op, type: Integer

	def mayorque(op1,op2)
		if op1>=op2
			mayor = 0
			
		else
			mayor = 1
		end
		return mayor
	end
	
	def estimation
		address = "http://localhost:5000/predict/#{self.op1.to_i}/#{self.op}/#{self.op2.to_i}/#{self.mayorque(self.op1,self.op2).to_i}"
		str = URI.escape(address) 
		uri = URI.parse(str)
		#string tipo [ numero]
		self.estimate = Net::HTTP.get(uri)[2..-2]
	end
end

