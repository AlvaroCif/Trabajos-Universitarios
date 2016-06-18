require 'net/http'

class CalculosController < ApplicationController
  before_action :set_calculo, only: [:show, :edit, :update, :destroy, :answer]

  # GET /calculos
  # GET /calculos.json
  def index
    @calculos = Calculo.all
  end

  # GET /calculos/1
  # GET /calculos/1.json
  def show
  end

  # GET /calculos/new
  def new
    @calculo = Calculo.new

    @calculo.op1=rand(100)
	@calculo.op2=rand(100)
	aux = 0
	if aux == 0
		@calculo.operador = "+"
		@calculo.op = 1
	elsif aux == 1
		@calculo.operador = "-"
		@calculo.op = 2
	elsif aux == 2
		@calculo.operador = "*"
		@calculo.op = 0
	else
		@calculo.operador = "/"
		@calculo.op = 3
		while @calculo.op2 == 0 do
			@calculo.op2=rand(100)
		end
	end
	
    @calculo.estimation
	@calculo.t0=Time.new
	@calculo.save
  end
  
  def answer
	@calculo= Calculo.find(params[:id])
	if @calculo.operador == "+"
		if @calculo.op1 + @calculo.op2 == params[:resultado].to_i
			@calculo.t1 = Time.new
			@calculo.save
		else
			render :new
		end
		
	elsif @calculo.operador == "-"
		if @calculo.op1 - @calculo.op2 == params[:resultado].to_i
			@calculo.t1 = Time.new
			@calculo.save
		else
			render :new
		end
	elsif @calculo.operador == "*"
		if @calculo.op1 * @calculo.op2 == params[:resultado].to_i
			@calculo.t1 = Time.new
			@calculo.save
		else
			render :new
		end
	elsif @calculo.operador == "/"
		if @calculo.op1 / @calculo.op2 == params[:resultado].to_i
			@calculo.t1 = Time.new
			@calculo.save
		else
			render :new
		end
	end
	@calculo.medicion = @calculo.t1.to_f - @calculo.t0.to_f
	@calculo.save
  end



  private
    # Use callbacks to share common setup or constraints between actions.
    def set_calculo
      @calculo = Calculo.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def calculo_params
      params.require(:calculo).permit(:op1, :op2, :operando, :t0, :t1)
    end
end
