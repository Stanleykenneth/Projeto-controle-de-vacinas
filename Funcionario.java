import javax.swing.JOptionPane;

public class Funcionario extends Pessoa   {
    private int registro;
    private String senha;

    Funcionario(String n, String cpf, int data, int r, String s){
        super(n, cpf, data);
        registro = r;
        senha = s;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean validar() {
        if (registro == 1234 && senha.equals("teste123")){
            return true;
        }
        
        else{
            JOptionPane.showMessageDialog(null, "Registro ou senha inválidos");
            return false;   
        }
                        
    }
    
    @Override
    public String toString(){
        
        return "Bem vindo ao sistema " + super.getNome();
         
    }

    
    
    
    

   
}
