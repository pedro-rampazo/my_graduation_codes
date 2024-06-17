from google.colab import drive
import matplotlib.pyplot as plt
import pandas as pd

# CARREGANDO DADOS DA PLANILHA
drive.mount("/content/drive")
file_path = '/content/drive/My Drive/registro_ocupacao_hospitalar_covid19_2020.csv'

# LENDO DADOS DA PLANILHA
registro = pd.read_csv(file_path)

registro = registro[registro["ocupacaoSuspeitoUti"] >= 0]

# Gerar o boxplot
plt.figure(figsize=(10, 6))
plt.boxplot(registro["ocupacaoSuspeitoUti"], showfliers=True)
plt.title('Ocupações da UTI por suspeita de COVID-19')
plt.ylabel("Ocupações")
plt.show()
