/*PROJETO CRIADOR POR:
RGM: 26952505	Alana Caroline Barros dos Santos
RGM: 26732793	Gabriela Muniz Rezende
RGM: 28062426	Kenneth Stanley Neves dos Santos
RGM: 27719821	Marcus Vinicius Ignacio*/

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControleVacinas {
    public static void main(String[] args) {
        // declaração dos objetos
        Funcionario funcionario;
        Paciente paciente;
        Vacina vacina;

        ArrayList<Vacina> vacinas = new ArrayList<Vacina>();

        ArrayList<Pessoa> pacientes = new ArrayList<Pessoa>();

        String nomeFuncionario, senhaFuncionario;
        int registroFuncionario;

        String nomeVacina, fabricanteVacina, loteVacina;
        int qtdVacina, validadeVacina;

        String nomePaciente, cpfPaciente;
        int dataNascimentoPaciente, qtdDose;

        nomeFuncionario = JOptionPane.showInputDialog("Digite o seu nome: ");
        registroFuncionario = Integer.parseInt(JOptionPane.showInputDialog("Digite o seu registro: "));
        senhaFuncionario = JOptionPane.showInputDialog("Digite a sua senha: ");
        funcionario = new Funcionario(nomeFuncionario, "", 0, registroFuncionario, senhaFuncionario);

        if (funcionario.validar() == true) {
            JOptionPane.showMessageDialog(null, funcionario.toString());
            int opcao = 0;
            while (opcao != 6) {
                opcao = Integer.parseInt(JOptionPane
                        .showInputDialog(("<--------- MENU DE OPÇÕES ---------->" + "\n[1] Registra uma nova vacina"
                                + "\n[2] Adicionar nova quantidade " + "\n[3] Relatório de estoque "
                                + "\n[4] Remover Vacina " + "\n[5] Cadastro paciente " + "\n[6] Sair\n")));

                switch (opcao) {
                case 1:
                    nomeVacina = JOptionPane.showInputDialog("Digite o nome da vacina: ");
                    fabricanteVacina = JOptionPane.showInputDialog("Digite o fabricante: ");
                    loteVacina = JOptionPane.showInputDialog("Digite o lote: ");
                    qtdVacina = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de vacinas: "));
                    validadeVacina = Integer.parseInt(JOptionPane.showInputDialog("Digite a validade: (ddmmaa)"));
                    vacina = new Vacina(nomeVacina, fabricanteVacina, loteVacina, qtdVacina, validadeVacina);
                    vacinas.add(vacina);
                    break;

                case 2:
                    loteVacina = JOptionPane.showInputDialog(
                            "<---------- ADICIONAR QTDE DE VACINA ---------->\nDigite o lote da vacina: ");
                    for (Vacina lote : vacinas) {
                        if (vacinas.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Não há lotes para adicionar vacinas!");
                        } else if (lote.validarLote(loteVacina)) {
                            qtdVacina = Integer.parseInt(
                                    JOptionPane.showInputDialog("Lote" + loteVacina + " da " + lote.getNomeVacina()
                                            + " encontrado!! \nDigite a quantidade de vacinas que deseja adicionar: "));
                            lote.somaVacina(qtdVacina);
                            JOptionPane.showMessageDialog(null, "Quantidade adicionada");

                        }
                        // VERIFICAR COM ELSE COM O LOTE VALIDA
                    }
                    break;

                case 3:
                    String relatorio = "";
                    if (vacinas.isEmpty()) {
                        JOptionPane.showMessageDialog(null,
                                "Relatório vazio!!  \nPara cadastrar uma nova vacina digite 1 no MENU DE OPÇÕES");
                    } else {
                        for (int i = 0; i < vacinas.size(); i++) {
                            relatorio += vacinas.get(i).toString();
                        }
                        JOptionPane.showMessageDialog(null, relatorio);

                    }
                    break;

                case 4:
                    loteVacina = JOptionPane.showInputDialog("Digite o lote que deseja remover: ");
                    for (int i = 0; i < vacinas.size(); i++) {
                        Vacina loteVacina2 = vacinas.get(i);
                        if (loteVacina2.getLoteVacina().equals(loteVacina)) {
                            vacinas.remove(loteVacina2);
                            JOptionPane.showMessageDialog(null, "Lote removido");
                            break;

                        }

                    }
                    break;
                case 5:
                    int opcao1 = 0;

                    while (opcao1 != 3) {
                        opcao1 = Integer.parseInt(JOptionPane.showInputDialog(
                                "<----------- MENU PACIENTE ----------- >" + "\n[1] - Cadastro paciente"
                                        + "\n[2] - Relatório de vacinados" + "\n[3] - Voltar ao MENU de OPÇÕES\n"));
                        switch (opcao1) {
                        case 1:
                            nomePaciente = JOptionPane.showInputDialog("Digite o nome do paciente: ");
                            cpfPaciente = JOptionPane.showInputDialog("Digite o cpf do paciente: ");
                            dataNascimentoPaciente = Integer
                                    .parseInt(JOptionPane.showInputDialog("Digite a data de nascimento: (ddmmaa)"));
                            loteVacina = JOptionPane.showInputDialog("Digite o lote aplicado: ");
                            for (Vacina peslote : vacinas) {
                                if (peslote.getLoteVacina().equals(loteVacina)) {
                                    qtdDose = Integer.parseInt(JOptionPane.showInputDialog("Lote" + loteVacina
                                            + " encontrado!! \nDigite a quantidade de aplicações: "));
                                    peslote.subVacina(qtdDose);
                                    paciente = new Paciente(nomePaciente, cpfPaciente, dataNascimentoPaciente, qtdDose,
                                            peslote.getNomeVacina());
                                    pacientes.add(paciente);
                                    JOptionPane.showMessageDialog(null, "Paciente cadastrado");

                                }

                            }

                            break;

                        case 2:
                            String relatorio1 = "";
                            for (Pessoa p : pacientes) {
                                relatorio1 += p.toString();
                            }
                            JOptionPane.showMessageDialog(null, relatorio1);

                            break;

                        }
                    }

                }
            }
            JOptionPane.showMessageDialog(null, "Obrigada por utilizar o nosso programa");

        }

    }

}
