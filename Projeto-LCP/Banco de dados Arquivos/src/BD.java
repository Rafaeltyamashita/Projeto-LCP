//Linha INTEGER,Nome VARCHAR(30),Genero Varchar(10),Idade Integer,Data_de_Nascimento DATE,Ano_de_Ingresso INTEGER,Previsao_Saida DATE,Data_Saida DATE,Predio INTEGER,Bloco Integer,Apartamento Integer,Advertencias INTEGER)
//Morador(String nome,String genero,Date data_nascimento,int ano_ingresso,Date previsao_saida)
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 public class BD {
    /**
     *
     * @param Tabela
     */
    //cria tabela para Morador
    public static void criar_Tabela_Morador(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(Linha INTEGER,Nome VARCHAR(30),Idade INTEGER,Genero Varchar(10),Data_de_Nascimento DATE,Ano_de_Ingresso INTEGER,Previsao_Saida DATE,Data_Saida DATE,Predio INTEGER,Bloco Integer,Apartamento Integer,Advertencias INTEGER)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //cria tabela para Predio
     public static void criar_Tabela_Predio(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(N_Predio INTEGER,N_Ocupantes INTEGER)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //cria tabela para Bloco
     public static void criar_Tabela_Bloco(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(N_Bloco INTEGER,N_Ocupantes INTEGER)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
      //cria tabela para Apartamento
     public static void criar_Tabela_Apartamento(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("CREATE TABLE " + Tabela + "(N_Apartamento INTEGER,Genero VARCHAR(10),N_Ocupantes INTEGER),Nome_Arquivo VARCHAR(20)");
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela criada com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //exclui Tabela
    public static void exclui_Tabela(String Tabela){
     try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("DROP TABLE " + Tabela);
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    System.out.println("Tabela excluida com sucesso \n");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //exclui do banco de dados dependendo do nome
    public static void exclui(String Nome, String Tabela){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "DELETE FROM "+ Tabela + " WHERE Nome = ? ";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setString(1, Nome);
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    
    //muda se campo é previsao de saida,data_saida,data_nascimento
    public static void update_Tabela(Date Valor_troca,String Tabela,String Campo,int linha){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("UPDATE " + Tabela + " SET " + Campo + " = ? where linha = ?");
    
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setDate(1, Valor_troca); //seta primeira ?
    pstmt.setInt(2,linha);  //seta segunda ?
    
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //se campo é Nome ou Genero
    public static void update_Tabela1(String Valor_troca,String Tabela,String Campo,int linha){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("UPDATE " + Tabela + " SET " + Campo + " = ? where linha = ?");
    
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setString(1, Valor_troca); //seta primeira ?
    pstmt.setInt(2,linha);  //seta segunda ?
    
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    //se campo é idade,ano_de_ingresso,predio,bloco,apartamento
    public static void update_Tabela2(int Valor_troca,String Tabela,String Campo,int linha){
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = ("UPDATE " + Tabela + " SET " + Campo + " = ? where linha = ?");
    
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, Valor_troca); //seta primeira ?
    pstmt.setInt(2,linha);  //seta segunda ?
    
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    
    stm.execute("SHUTDOWN");
    }catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
    }catch(SQLException e){
    System.out.println("Erro de SQL: "+e);    
    }
    }
    
    //insere no banco de dados o objeto morador na tabela morador
    public static void insere(Morador m,int linha){
    String nome,genero;
    Date data1,data2;
    int ano;
    try{
    Class.forName("org.hsqldb.jdbcDriver"); //acessa driver do banco de dados
    //estabelece conexão com o baco de dados
    Connection con = DriverManager.getConnection("jdbc:hsqldb:file:C:\\Users\\rafae\\Downloads\\Unesp\\LCP\\Projeto-LCP\\Banco de Dados\\BD", "sa", ""); //CAMPOS UR/Login/senha
    Statement stm= con.createStatement(); //criada instancia para trabalhar com instruções do banco de dados
    nome = m.getNome();
    genero = m.getGenero();
    int idade = m.getidade();
    data1 = (Date) m.getData_nascimento();
    ano = m.getAno_ingresso();
    data2 = (Date) m.getPrevisao_saida(); 
    //Cria a statement para inserir os campos de Morador
    String INSERT_RECORD;
    INSERT_RECORD = "insert into Morador (LINHA,NOME,IDADE,GENERO,Data_de_Nascimento,Ano_de_Ingresso,PREVISAO_SAIDA) VALUES(?,?,?,?,?,?,?)";
    PreparedStatement pstmt = con.prepareStatement(INSERT_RECORD);
    pstmt.setInt(1, linha); // seta primeira ?
    pstmt.setString(2, nome);
    pstmt.setInt(3, idade);
    pstmt.setString(4, genero);
    pstmt.setDate(5, data1);
    pstmt.setInt(6, ano);
    pstmt.setDate(7, data2);
    
    pstmt.executeUpdate();//coloca a statement insery_record em executeUpdate para atualizar o valor
    // Mostra os resultados de todos os campos selecionados
    ResultSet rs;
    rs = stm.executeQuery("SELECT * FROM Morador");
    while(rs.next()){
        nome = rs.getString("nome");
        genero = rs.getString("genero");
        int i = rs.getInt("linha");
        idade = rs.getInt("idade");
        data1 = rs.getDate("Data_de_Nascimento");
        ano = rs.getInt("Ano_de_Ingresso");
        data2 = rs.getDate("PREVISAO_SAIDA");
        System.out.println(nome + "\n" + genero + "\n " +idade + "\n "+ i + "\n "+ data1 + "\n " + ano + "\n " + data2  + "\n " );
    }
    // necessario para desligar o banco de dados e salvar os dados inseridos
    stm.execute("SHUTDOWN");
}catch(ClassNotFoundException e){
    System.out.println("Erro ao carregar o driver JDBC. ");
}catch(SQLException e){
    System.out.println("Erro de SQL: "+e);
}
    }
    public static void main(String[] args) throws ParseException{
    String nome,genero;
    java.sql.Date data_nascimento,previsao_saida;
    int ano;
     ano = 2000; 
     SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
     data_nascimento = new java.sql.Date(format.parse("20/06/2000").getTime());
     previsao_saida = new java.sql.Date(format.parse("30/12/1999").getTime());
     Morador m1 = new Morador("Rafael","Masculino",data_nascimento,ano,previsao_saida);
     insere(m1,1);
   }     
}