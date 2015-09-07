unit U_data_module;

interface

uses
  SysUtils, Classes, DB, IBCustomDataSet, IBDatabase, IBQuery;

type
  TDataModule1 = class(TDataModule)
    IBD_principal: TIBDatabase;
    IBT_cidade: TIBTransaction;
    IBD_cidade: TIBDataSet;
    IBD_cidadeCD_CIDADE: TIntegerField;
    IBD_cidadeDS_CIDADE: TIBStringField;
    IBD_cidadeDS_UF: TIBStringField;
    IBQ_cidade: TIBQuery;
    IBQ_cidadeCD_CIDADE: TIntegerField;
    IBQ_cidadeDS_CIDADE: TIBStringField;
    IBQ_cidadeDS_UF: TIBStringField;
    IBQUltimacidade: TIBQuery;
    IBQUltimacidadeULTIMO: TLargeintField;
    IBD_uf: TIBDataSet;
    IBD_ufDS_UF: TIBStringField;
    IBD_ufNM_UF: TIBStringField;
    IBQ_consulta_uf: TIBQuery;
    IBQ_consulta_ufDS_UF: TIBStringField;
    IBQ_consulta_ufNM_UF: TIBStringField;
    IBQ_consulta_usuario: TIBQuery;
    IBQ_consulta_usuarioDS_LOGIN: TIBStringField;
    IBQ_consulta_usuarioDS_SENHA: TIBStringField;
    IBD_usuario: TIBDataSet;
    IBD_usuarioDS_LOGIN: TIBStringField;
    IBD_usuarioDS_SENHA: TIBStringField;
    procedure IBD_cidadeBeforePost(DataSet: TDataSet);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  DataModule1: TDataModule1;

implementation

{$R *.dfm}

procedure TDataModule1.IBD_cidadeBeforePost(DataSet: TDataSet);
begin
     if DataModule1.IBD_cidade.State in [dsinsert] then
   begin
    DataModule1.IBQUltimacidade.Close;
    Datamodule1.IBQUltimacidade.SQL.clear;
    Datamodule1.IBQUltimacidade.SQL.Add('SELECT COALESCE(MAX(CD_CIDADE),0) + 1 AS ULTIMO FROM CIDADE');
    DataModule1.IBQUltimacidade.Open;
    DataModule1.IBD_cidadeCD_CIDADE.AsInteger := DataMOdule1.IBQUltimacidadeULTIMO.AsInteger;
   end;
end;

end.
