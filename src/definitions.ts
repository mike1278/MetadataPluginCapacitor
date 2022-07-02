export interface MetadataReturn { metadata: Record<string, unknown> }

export interface MetadataPlugin {
  metadata(options: { value: string }): Promise<{ value: string }>;
}
