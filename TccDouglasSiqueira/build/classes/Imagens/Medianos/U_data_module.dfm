object DataModule1: TDataModule1
  OldCreateOrder = False
  Left = 358
  Top = 168
  Height = 393
  Width = 410
  object IBD_principal: TIBDatabase
    Connected = True
    DatabaseName = 'C:\Trabalho Integrador\BANCO_TRABALHO_INTEGRADOR.GDB'
    Params.Strings = (
      'user_name=SYSDBA'
      'password=masterkey'
      'lc_ctype=WIN1250')
    LoginPrompt = False
    IdleTimer = 0
    SQLDialect = 3
    TraceFlags = []
    Left = 24
    Top = 16
  end
  object IBT_cidade: TIBTransaction
    Active = True
    DefaultDatabase = IBD_principal
    AutoStopAction = saNone
    Left = 96
    Top = 16
  end
  object IBD_cidade: TIBDataSet
    Database = IBD_principal
    Transaction = IBT_cidade
    BeforePost = IBD_cidadeBeforePost
    BufferChunks = 1000
    CachedUpdates = False
    DeleteSQL.Strings = (
      'delete from CIDADE'
      'where'
      '  CD_CIDADE = :OLD_CD_CIDADE')
    InsertSQL.Strings = (
      'insert into CIDADE'
      '  (CD_CIDADE, DS_CIDADE, DS_UF)'
      'values'
      '  (:CD_CIDADE, :DS_CIDADE, :DS_UF)')
    RefreshSQL.Strings = (
      'Select '
      '  CD_CIDADE,'
      '  DS_CIDADE,'
      '  DS_UF'
      'from CIDADE '
      'where'
      '  CD_CIDADE = :CD_CIDADE')
    SelectSQL.Strings = (
      'select  * from CIDADE')
    ModifySQL.Strings = (
      'update CIDADE'
      'set'
      '  CD_CIDADE = :CD_CIDADE,'
      '  DS_CIDADE = :DS_CIDADE,'
      '  DS_UF = :DS_UF'
      'where'
      '  CD_CIDADE = :OLD_CD_CIDADE')
    Active = True
    Left = 168
    Top = 16
    object IBD_cidadeCD_CIDADE: TIntegerField
      FieldName = 'CD_CIDADE'
      Origin = 'CIDADE.CD_CIDADE'
      Required = True
    end
    object IBD_cidadeDS_CIDADE: TIBStringField
      FieldName = 'DS_CIDADE'
      Origin = 'CIDADE.DS_CIDADE'
      Size = 60
    end
    object IBD_cidadeDS_UF: TIBStringField
      FieldName = 'DS_UF'
      Origin = 'CIDADE.DS_UF'
      FixedChar = True
      Size = 2
    end
  end
  object IBQ_cidade: TIBQuery
    Database = IBD_principal
    Transaction = IBT_cidade
    Active = True
    BufferChunks = 1000
    CachedUpdates = False
    SQL.Strings = (
      'select * from CIDADE'
      'where'
      'cd_cidade =:PCIDADE')
    Left = 216
    Top = 16
    ParamData = <
      item
        DataType = ftUnknown
        Name = 'PCIDADE'
        ParamType = ptUnknown
      end>
    object IBQ_cidadeCD_CIDADE: TIntegerField
      FieldName = 'CD_CIDADE'
      Origin = 'CIDADE.CD_CIDADE'
      Required = True
    end
    object IBQ_cidadeDS_CIDADE: TIBStringField
      FieldName = 'DS_CIDADE'
      Origin = 'CIDADE.DS_CIDADE'
      Size = 60
    end
    object IBQ_cidadeDS_UF: TIBStringField
      FieldName = 'DS_UF'
      Origin = 'CIDADE.DS_UF'
      FixedChar = True
      Size = 2
    end
  end
  object IBQUltimacidade: TIBQuery
    Database = IBD_principal
    Transaction = IBT_cidade
    Active = True
    BufferChunks = 1000
    CachedUpdates = False
    SQL.Strings = (
      'select coalesce(max(CD_CIDADE),0)+1 as ultimo from CIDADE')
    Left = 272
    Top = 16
    object IBQUltimacidadeULTIMO: TLargeintField
      FieldName = 'ULTIMO'
    end
  end
  object IBD_uf: TIBDataSet
    Database = IBD_principal
    Transaction = IBT_cidade
    BufferChunks = 1000
    CachedUpdates = False
    DeleteSQL.Strings = (
      'delete from UF'
      'where'
      '  DS_UF = :OLD_DS_UF')
    InsertSQL.Strings = (
      'insert into UF'
      '  (DS_UF, NM_UF)'
      'values'
      '  (:DS_UF, :NM_UF)')
    RefreshSQL.Strings = (
      'Select '
      '  DS_UF,'
      '  NM_UF'
      'from UF '
      'where'
      '  DS_UF = :DS_UF')
    SelectSQL.Strings = (
      'select * from UF')
    ModifySQL.Strings = (
      'update UF'
      'set'
      '  DS_UF = :DS_UF,'
      '  NM_UF = :NM_UF'
      'where'
      '  DS_UF = :OLD_DS_UF')
    Active = True
    Left = 24
    Top = 104
    object IBD_ufDS_UF: TIBStringField
      FieldName = 'DS_UF'
      Origin = 'UF.DS_UF'
      Required = True
      FixedChar = True
      Size = 2
    end
    object IBD_ufNM_UF: TIBStringField
      FieldName = 'NM_UF'
      Origin = 'UF.NM_UF'
      Size = 30
    end
  end
  object IBQ_consulta_uf: TIBQuery
    Database = IBD_principal
    Transaction = IBT_cidade
    BufferChunks = 1000
    CachedUpdates = False
    SQL.Strings = (
      'select  *from UF'
      'where'
      'DS_UF=:PUF')
    Left = 88
    Top = 104
    ParamData = <
      item
        DataType = ftUnknown
        Name = 'PUF'
        ParamType = ptUnknown
      end>
    object IBQ_consulta_ufDS_UF: TIBStringField
      FieldName = 'DS_UF'
      Origin = 'UF.DS_UF'
      Required = True
      FixedChar = True
      Size = 2
    end
    object IBQ_consulta_ufNM_UF: TIBStringField
      FieldName = 'NM_UF'
      Origin = 'UF.NM_UF'
      Size = 30
    end
  end
  object IBQ_consulta_usuario: TIBQuery
    Database = IBD_principal
    Transaction = IBT_cidade
    Active = True
    BufferChunks = 1000
    CachedUpdates = False
    SQL.Strings = (
      'select * from USUARIO')
    Left = 16
    Top = 184
    object IBQ_consulta_usuarioDS_LOGIN: TIBStringField
      FieldName = 'DS_LOGIN'
      Origin = 'USUARIO.DS_LOGIN'
      Required = True
      Size = 100
    end
    object IBQ_consulta_usuarioDS_SENHA: TIBStringField
      FieldName = 'DS_SENHA'
      Origin = 'USUARIO.DS_SENHA'
      Required = True
      Size = 100
    end
  end
  object IBD_usuario: TIBDataSet
    Database = IBD_principal
    Transaction = IBT_cidade
    BufferChunks = 1000
    CachedUpdates = False
    SelectSQL.Strings = (
      'select * from USUARIO'
      'where'
      'DS_LOGIN=:PUSUARIO')
    Active = True
    Left = 80
    Top = 184
    object IBD_usuarioDS_LOGIN: TIBStringField
      FieldName = 'DS_LOGIN'
      Origin = 'USUARIO.DS_LOGIN'
      Required = True
      Size = 100
    end
    object IBD_usuarioDS_SENHA: TIBStringField
      FieldName = 'DS_SENHA'
      Origin = 'USUARIO.DS_SENHA'
      Required = True
      Size = 100
    end
  end
end
