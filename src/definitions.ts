export interface MetadataPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
